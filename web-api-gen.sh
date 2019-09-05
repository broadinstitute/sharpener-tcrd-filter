#!/usr/bin/env bash

set -e

codegen_jar=~/software/swagger/swagger-codegen-cli.jar
web_api_dir=web
api_specs=gene_transformer_api.yml

web_api_dir_new="${web_api_dir}_new"
web_api_dir_old="${web_api_dir}_old"

if [[ $(java -jar ${codegen_jar} validate -i ${api_specs} | wc -l)  -ge 2 ]]; then
  exit 1
fi

echo ${web_api_dir_new}

if [[ -e "${web_api_dir_new}" ]]; then
  rm -r ${web_api_dir_new}
fi

mkdir ${web_api_dir_new}
cp ${api_specs} ${web_api_dir_new}
cd ${web_api_dir_new}
java -jar ${codegen_jar} generate -l scalatra -i ${api_specs} --model-package sharpener.tcrd.model --api-package sharpener.tcrd.server.api
cd ..

if [[ -e "${web_api_dir_old}" ]]; then
  rm -r ${web_api_dir_old}
fi

if [[ -e "${web_api_dir}" ]]; then
  mv ${web_api_dir} ${web_api_dir_old}
fi
mv ${web_api_dir_new} ${web_api_dir}

echo "Done!"

