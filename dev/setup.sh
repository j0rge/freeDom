sudo update-alternatives  --install /usr/bin/java java /opt/jdk/default/bin/java 1500
sudo update-alternatives  --install /usr/bin/jar jar /opt/jdk/default/bin/jar 1500
sudo update-alternatives  --install /usr/bin/jvisualvm jvisualvm /opt/jdk/default/bin/jvisualvm 1500
sudo update-alternatives  --install /usr/bin/idea idea /opt/jdk/default/bin/idea 1500
sudo update-alternatives  --install /usr/bin/mvn mvn /opt/mvn/default/bin/mvn 1500
sudo find /etc -type f -exec sudo grep -P "\WPATH\W" {} \; -print
sudo vim -p /etc/login.defs /etc/zsh/zshenv
sudo vim /etc/ca-certificates/update.d/jks-keystore


