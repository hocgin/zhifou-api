# 发布文章脚本
#!/usr/bin/env bash
ip=130.211.243.95
path=/prod/post

# ========================
ssh root@$ip "rm -rf $path/*"
scp -r ./docs/post/* root@$ip:$path/
echo -e '\n'
date