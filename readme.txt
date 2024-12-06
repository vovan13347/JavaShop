
[Unit]
Description=
After=network.target

[Service]
User=root
Group=root
WorkingDirectory=/projects/lab/myshop
ExecStart=mvn spring-boot:run
Restart=always
RestartSec=10

[Install]
WantedBy=multi-user.target


sudo systemctl daemon-reload
sudo systemctl enable myapp.service
sudo systemctl start myapp.service

