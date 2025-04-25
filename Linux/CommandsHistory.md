veronik@UbuntuM3:~$ mysql -v
Command 'mysql' not found, but can be installed with:
sudo apt install mysql-client-core    # version 8.4.4-0ubuntu2, or
sudo apt install mariadb-client-core  # version 1:11.4.5-1
veronik@UbuntuM3:~$ wget -c https://dev.mysql.com/get/mysql-apt-config_0.8.34-1_all.deb
--2025-04-22 21:54:37--  https://dev.mysql.com/get/mysql-apt-config_0.8.34-1_all.deb
Resolving dev.mysql.com (dev.mysql.com)... 184.51.234.232, 2001:2030:15:1b0::2e31, 2001:2030:15:189::2e31
Connecting to dev.mysql.com (dev.mysql.com)|184.51.234.232|:443... connected.
HTTP request sent, awaiting response... 302 Moved Temporarily
Location: https://repo.mysql.com//mysql-apt-config_0.8.34-1_all.deb [following]
--2025-04-22 21:54:38--  https://repo.mysql.com//mysql-apt-config_0.8.34-1_all.deb
Resolving repo.mysql.com (repo.mysql.com)... 23.52.19.30, 2a02:26f0:7100:483::1d68, 2a02:26f0:7100:480::1d68
Connecting to repo.mysql.com (repo.mysql.com)|23.52.19.30|:443... connected.
HTTP request sent, awaiting response... 200 OK

    The file is already fully retrieved; nothing to do.

veronik@UbuntuM3:~$ sudo dpkg -i mysql-apt-config_0.8.34-1_all.deb
(Reading database ... 149127 files and directories currently installed.)
Preparing to unpack mysql-apt-config_0.8.34-1_all.deb ...
Unpacking mysql-apt-config (0.8.34-1) over (0.8.34-1) ...
Setting up mysql-apt-config (0.8.34-1) ...
veronik@UbuntuM3:~$  sudo apt-get update
Hit:1 http://ports.ubuntu.com/ubuntu-ports plucky InRelease
Hit:2 http://ports.ubuntu.com/ubuntu-ports plucky-updates InRelease
Hit:3 http://ports.ubuntu.com/ubuntu-ports plucky-backports InRelease
Hit:4 http://ports.ubuntu.com/ubuntu-ports plucky-security InRelease
Get:5 http://repo.mysql.com/apt/ubuntu plucky InRelease [22.6 kB]
Fetched 22.6 kB in 11s (2,105 B/s)  
Reading package lists... Done
N: Skipping acquire of configured file 'mysql-apt-config/binary-arm64/Packages' as repository 'http://repo.mysql.com/apt/ubuntu plucky InRelease' doesn't support architecture 'arm64'
N: Skipping acquire of configured file 'mysql-8.4-lts/binary-arm64/Packages' as repository 'http://repo.mysql.com/apt/ubuntu plucky InRelease' doesn't support architecture 'arm64'
N: Skipping acquire of configured file 'mysql-tools/binary-arm64/Packages' as repository 'http://repo.mysql.com/apt/ubuntu plucky InRelease' doesn't support architecture 'arm64'
veronik@UbuntuM3:~$ sudo apt-get install mysql-server
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
Solving dependencies... Done
The following additional packages will be installed:
  libaio1t64 libcgi-fast-perl libcgi-pm-perl libfcgi-bin libfcgi-perl
  libfcgi0t64 libhtml-template-perl libmecab2 libprotobuf-lite32t64
  mecab-ipadic mecab-ipadic-utf8 mecab-utils mysql-client mysql-client-core
  mysql-common mysql-server-core
Suggested packages:
  libipc-sharedcache-perl mailx tinyca
The following NEW packages will be installed:
  libaio1t64 libcgi-fast-perl libcgi-pm-perl libfcgi-bin libfcgi-perl
  libfcgi0t64 libhtml-template-perl libmecab2 libprotobuf-lite32t64
  mecab-ipadic mecab-ipadic-utf8 mecab-utils mysql-client mysql-client-core
  mysql-common mysql-server mysql-server-core
0 upgraded, 17 newly installed, 0 to remove and 0 not upgraded.
Need to get 29.7 MB of archives.
After this operation, 235 MB of additional disk space will be used.
Do you want to continue? [Y/n] y
Get:1 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 mysql-common all 5.8+1.1.1ubuntu1 [6,922 B]
Get:2 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 mysql-client-core arm64 8.4.4-0ubuntu2 [2,094 kB]
Get:3 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 mysql-client arm64 8.4.4-0ubuntu2 [9,122 B]
Get:4 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 libaio1t64 arm64 0.3.113-8 [7,310 B]
Get:5 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 libmecab2 arm64 0.996-15.1build2 [191 kB]
Get:6 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 libprotobuf-lite32t64 arm64 3.21.12-10build2 [220 kB]
Get:7 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 mysql-server-core arm64 8.4.4-0ubuntu2 [18.8 MB]
Get:8 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 mysql-server arm64 8.4.4-0ubuntu2 [1,364 kB]
Get:9 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 libcgi-pm-perl all 4.67-1 [185 kB]
Get:10 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 libfcgi0t64 arm64 2.4.2-2.1build1 [27.1 kB]
Get:11 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 libfcgi-perl arm64 0.82+ds-3build3 [20.7 kB]
Get:12 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 libcgi-fast-perl all 1:2.17-1 [10.3 kB]
Get:13 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 libfcgi-bin arm64 2.4.2-2.1build1 [10.7 kB]
Get:14 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 libhtml-template-perl all 2.97-2build1 [58.3 kB]
Get:15 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 mecab-utils arm64 0.996-15.1build2 [5,056 B]
Get:16 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 mecab-ipadic all 2.7.0-20070801+main-3 [6,718 kB]
Get:17 http://ports.ubuntu.com/ubuntu-ports plucky/main arm64 mecab-ipadic-utf8 all 2.7.0-20070801+main-3 [4,384 B]
Fetched 29.7 MB in 2min 32s (195 kB/s)                                         
Preconfiguring packages ...
Selecting previously unselected package mysql-common.
(Reading database ... 149127 files and directories currently installed.)
Preparing to unpack .../0-mysql-common_5.8+1.1.1ubuntu1_all.deb ...
Unpacking mysql-common (5.8+1.1.1ubuntu1) ...
Selecting previously unselected package mysql-client-core.
Preparing to unpack .../1-mysql-client-core_8.4.4-0ubuntu2_arm64.deb ...
Unpacking mysql-client-core (8.4.4-0ubuntu2) ...
Selecting previously unselected package mysql-client.
Preparing to unpack .../2-mysql-client_8.4.4-0ubuntu2_arm64.deb ...
Unpacking mysql-client (8.4.4-0ubuntu2) ...
Selecting previously unselected package libaio1t64:arm64.
Preparing to unpack .../3-libaio1t64_0.3.113-8_arm64.deb ...
Unpacking libaio1t64:arm64 (0.3.113-8) ...
Selecting previously unselected package libmecab2:arm64.
Preparing to unpack .../4-libmecab2_0.996-15.1build2_arm64.deb ...
Unpacking libmecab2:arm64 (0.996-15.1build2) ...
Selecting previously unselected package libprotobuf-lite32t64:arm64.
Preparing to unpack .../5-libprotobuf-lite32t64_3.21.12-10build2_arm64.deb ...
Unpacking libprotobuf-lite32t64:arm64 (3.21.12-10build2) ...
Selecting previously unselected package mysql-server-core.
Preparing to unpack .../6-mysql-server-core_8.4.4-0ubuntu2_arm64.deb ...
Unpacking mysql-server-core (8.4.4-0ubuntu2) ...
Setting up mysql-common (5.8+1.1.1ubuntu1) ...
update-alternatives: using /etc/mysql/my.cnf.fallback to provide /etc/mysql/my.cnf (my.cnf) in auto mode
Selecting previously unselected package mysql-server.
(Reading database ... 149331 files and directories currently installed.)
Preparing to unpack .../0-mysql-server_8.4.4-0ubuntu2_arm64.deb ...
Unpacking mysql-server (8.4.4-0ubuntu2) ...
Selecting previously unselected package libcgi-pm-perl.
Preparing to unpack .../1-libcgi-pm-perl_4.67-1_all.deb ...
Unpacking libcgi-pm-perl (4.67-1) ...
Selecting previously unselected package libfcgi0t64:arm64.
Preparing to unpack .../2-libfcgi0t64_2.4.2-2.1build1_arm64.deb ...
Unpacking libfcgi0t64:arm64 (2.4.2-2.1build1) ...
Selecting previously unselected package libfcgi-perl.
Preparing to unpack .../3-libfcgi-perl_0.82+ds-3build3_arm64.deb ...
Unpacking libfcgi-perl (0.82+ds-3build3) ...
Selecting previously unselected package libcgi-fast-perl.
Preparing to unpack .../4-libcgi-fast-perl_1%3a2.17-1_all.deb ...
Unpacking libcgi-fast-perl (1:2.17-1) ...
Selecting previously unselected package libfcgi-bin.
Preparing to unpack .../5-libfcgi-bin_2.4.2-2.1build1_arm64.deb ...
Unpacking libfcgi-bin (2.4.2-2.1build1) ...
Selecting previously unselected package libhtml-template-perl.
Preparing to unpack .../6-libhtml-template-perl_2.97-2build1_all.deb ...
Unpacking libhtml-template-perl (2.97-2build1) ...
Selecting previously unselected package mecab-utils.
Preparing to unpack .../7-mecab-utils_0.996-15.1build2_arm64.deb ...
Unpacking mecab-utils (0.996-15.1build2) ...
Selecting previously unselected package mecab-ipadic.
Preparing to unpack .../8-mecab-ipadic_2.7.0-20070801+main-3_all.deb ...
Unpacking mecab-ipadic (2.7.0-20070801+main-3) ...
Selecting previously unselected package mecab-ipadic-utf8.
Preparing to unpack .../9-mecab-ipadic-utf8_2.7.0-20070801+main-3_all.deb ...
Unpacking mecab-ipadic-utf8 (2.7.0-20070801+main-3) ...
Setting up libprotobuf-lite32t64:arm64 (3.21.12-10build2) ...
Setting up libmecab2:arm64 (0.996-15.1build2) ...
Setting up libfcgi0t64:arm64 (2.4.2-2.1build1) ...
Setting up libcgi-pm-perl (4.67-1) ...
Setting up libfcgi-bin (2.4.2-2.1build1) ...
Setting up libhtml-template-perl (2.97-2build1) ...
Setting up mecab-utils (0.996-15.1build2) ...
Setting up libaio1t64:arm64 (0.3.113-8) ...
Setting up mysql-client-core (8.4.4-0ubuntu2) ...
Setting up libfcgi-perl (0.82+ds-3build3) ...
Setting up mysql-client (8.4.4-0ubuntu2) ...
Setting up mecab-ipadic (2.7.0-20070801+main-3) ...
Compiling IPA dictionary for Mecab.  This takes long time...
reading /usr/share/mecab/dic/ipadic/unk.def ... 40
emitting double-array: 100% |###########################################| 
/usr/share/mecab/dic/ipadic/model.def is not found. skipped.
reading /usr/share/mecab/dic/ipadic/Noun.demonst.csv ... 120
reading /usr/share/mecab/dic/ipadic/Adj.csv ... 27210
reading /usr/share/mecab/dic/ipadic/Interjection.csv ... 252
reading /usr/share/mecab/dic/ipadic/Prefix.csv ... 221
reading /usr/share/mecab/dic/ipadic/Auxil.csv ... 199
reading /usr/share/mecab/dic/ipadic/Adverb.csv ... 3032
reading /usr/share/mecab/dic/ipadic/Noun.number.csv ... 42
reading /usr/share/mecab/dic/ipadic/Noun.csv ... 60477
reading /usr/share/mecab/dic/ipadic/Conjunction.csv ... 171
reading /usr/share/mecab/dic/ipadic/Noun.org.csv ... 16668
reading /usr/share/mecab/dic/ipadic/Postp.csv ... 146
reading /usr/share/mecab/dic/ipadic/Others.csv ... 2
reading /usr/share/mecab/dic/ipadic/Postp-col.csv ... 91
reading /usr/share/mecab/dic/ipadic/Noun.nai.csv ... 42
reading /usr/share/mecab/dic/ipadic/Noun.place.csv ... 72999
reading /usr/share/mecab/dic/ipadic/Adnominal.csv ... 135
reading /usr/share/mecab/dic/ipadic/Noun.name.csv ... 34202
reading /usr/share/mecab/dic/ipadic/Noun.adjv.csv ... 3328
reading /usr/share/mecab/dic/ipadic/Suffix.csv ... 1393
reading /usr/share/mecab/dic/ipadic/Noun.others.csv ... 151
reading /usr/share/mecab/dic/ipadic/Filler.csv ... 19
reading /usr/share/mecab/dic/ipadic/Noun.adverbal.csv ... 795
reading /usr/share/mecab/dic/ipadic/Noun.verbal.csv ... 12146
reading /usr/share/mecab/dic/ipadic/Noun.proper.csv ... 27328
reading /usr/share/mecab/dic/ipadic/Symbol.csv ... 208
reading /usr/share/mecab/dic/ipadic/Verb.csv ... 130750
emitting double-array: 100% |###########################################| 
reading /usr/share/mecab/dic/ipadic/matrix.def ... 1316x1316
emitting matrix      : 100% |###########################################| 

done!
update-alternatives: using /var/lib/mecab/dic/ipadic to provide /var/lib/mecab/dic/debian (mecab-dictionary) in auto mode
Setting up libcgi-fast-perl (1:2.17-1) ...
Setting up mysql-server-core (8.4.4-0ubuntu2) ...
Setting up mecab-ipadic-utf8 (2.7.0-20070801+main-3) ...
Compiling IPA dictionary for Mecab.  This takes long time...
reading /usr/share/mecab/dic/ipadic/unk.def ... 40
emitting double-array: 100% |###########################################| 
/usr/share/mecab/dic/ipadic/model.def is not found. skipped.
reading /usr/share/mecab/dic/ipadic/Noun.demonst.csv ... 120
reading /usr/share/mecab/dic/ipadic/Adj.csv ... 27210
reading /usr/share/mecab/dic/ipadic/Interjection.csv ... 252
reading /usr/share/mecab/dic/ipadic/Prefix.csv ... 221
reading /usr/share/mecab/dic/ipadic/Auxil.csv ... 199
reading /usr/share/mecab/dic/ipadic/Adverb.csv ... 3032
reading /usr/share/mecab/dic/ipadic/Noun.number.csv ... 42
reading /usr/share/mecab/dic/ipadic/Noun.csv ... 60477
reading /usr/share/mecab/dic/ipadic/Conjunction.csv ... 171
reading /usr/share/mecab/dic/ipadic/Noun.org.csv ... 16668
reading /usr/share/mecab/dic/ipadic/Postp.csv ... 146
reading /usr/share/mecab/dic/ipadic/Others.csv ... 2
reading /usr/share/mecab/dic/ipadic/Postp-col.csv ... 91
reading /usr/share/mecab/dic/ipadic/Noun.nai.csv ... 42
reading /usr/share/mecab/dic/ipadic/Noun.place.csv ... 72999
reading /usr/share/mecab/dic/ipadic/Adnominal.csv ... 135
reading /usr/share/mecab/dic/ipadic/Noun.name.csv ... 34202
reading /usr/share/mecab/dic/ipadic/Noun.adjv.csv ... 3328
reading /usr/share/mecab/dic/ipadic/Suffix.csv ... 1393
reading /usr/share/mecab/dic/ipadic/Noun.others.csv ... 151
reading /usr/share/mecab/dic/ipadic/Filler.csv ... 19
reading /usr/share/mecab/dic/ipadic/Noun.adverbal.csv ... 795
reading /usr/share/mecab/dic/ipadic/Noun.verbal.csv ... 12146
reading /usr/share/mecab/dic/ipadic/Noun.proper.csv ... 27328
reading /usr/share/mecab/dic/ipadic/Symbol.csv ... 208
reading /usr/share/mecab/dic/ipadic/Verb.csv ... 130750
emitting double-array: 100% |###########################################| 
reading /usr/share/mecab/dic/ipadic/matrix.def ... 1316x1316
emitting matrix      : 100% |###########################################| 

done!
update-alternatives: using /var/lib/mecab/dic/ipadic-utf8 to provide /var/lib/mecab/dic/debian (mecab-dictionary) in auto mode
Setting up mysql-server (8.4.4-0ubuntu2) ...
update-alternatives: using /etc/mysql/mysql.cnf to provide /etc/mysql/my.cnf (my.cnf) in auto mode
Renaming removed key_buffer and myisam-recover options (if present)
Created symlink '/etc/systemd/system/multi-user.target.wants/mysql.service' → '/usr/lib/systemd/system/mysql.service'.
Processing triggers for man-db (2.13.0-1) ...
Processing triggers for libc-bin (2.41-6ubuntu1) ...
veronik@UbuntuM3:~$ systemctl status mysql
● mysql.service - MySQL Community Server
     Loaded: loaded (/usr/lib/systemd/system/mysql.service; enabled; preset: en>
     Active: active (running) since Tue 2025-04-22 21:59:51 MSK; 6s ago
 Invocation: b79d12454b1f4eac804c330bdaba73ac
    Process: 6485 ExecStartPre=/usr/share/mysql/mysql-systemd-start pre (code=e>
   Main PID: 6494 (mysqld)
     Status: "Server is operational"
      Tasks: 35 (limit: 3924)
     Memory: 438.6M (peak: 451.8M)
        CPU: 638ms
     CGroup: /system.slice/mysql.service
             └─6494 /usr/sbin/mysqld

Apr 22 21:59:50 UbuntuM3 systemd[1]: Starting mysql.service - MySQL Community S>
Apr 22 21:59:51 UbuntuM3 systemd[1]: Started mysql.service - MySQL Community Se>
veronik@UbuntuM3:~$ sudo dpkg -r mysql-apt-config
(Reading database ... 149494 files and directories currently installed.)
Removing mysql-apt-config (0.8.34-1) ...
veronik@UbuntuM3:~$ 
