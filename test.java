

2. Connexion simple (2 pt)
Dans Alice :
ifconfig eth0 up
ifconfig eth0 add 3ffe:0:0:101::/64
ifconfig eth0 add adresse-IPV6-complète/64
Pour l’adresse IPv6 il faut fusionner l’adresse réseau avec l’adresse MAC.
Exemple :
HWaddr (MAC) : 02:04:06:3d:d2:90
inet6 addr : 3ffe:0:0:100::/64
adresse ipv6 complète : 3ffe::100:204:6ff:fe3d:d290/64
Pour voir l’adresse MAC il faut faire un :
ifconfig eth0
Dans Roger :
ifconfig eth0 up
ifconfig eth0 add 3ffe:0:0:101::/64
ifconfig eth0 add adresse-IPV6-complète/64
Pour tester la connectivité :
ping6 adresse-IPV6-complète (sans le /64)
3. Routage (2 pt)
Sur Caroline :
ifconfig eth0 up
ifconfig eth0 add 3ffe:0:0:102::/64
ifconfig eth0 add adresse-IPV6-complète/64
Sur Roger :
ifconfig eth1 up
ifconfig eth1 add 3ffe:0:0:102::/64
ifconfig eth1 add adresse-IPV6-complète/64
Route par défaut passant par Roger
Sur Alice :
route -A inet6 add default gw adresse-IPV6-Bob-eth0 dev eth0
Sur Caroline :
route -A inet6 add default gw adresse-IPV6-Bob-eth1 dev eth0
Activé le route par défaut :
Sur Bob :
echo 1 > /proc/sys/net/ipv6/conf/all/forwarding
Puis tester un ping6 entre Caroline et Alice.
