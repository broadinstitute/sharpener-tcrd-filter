# sharpener-tcrd-filter
REST API to adapt our TCRD API to the Gene Sharpener API

## How to run

First, run the [TCRD API](https://github.com/broadinstitute/tcrd-api).

Then open this with SBT, do "project web" and "jetty:start".

Either run both services on the same machine, or adjust base URL in sharpener.tcrd.server.api.TransformerBackend.

## API specs

API specs have been copied from
[here](https://github.com/broadinstitute/sharpener/blob/master/gene_transformer_api.yml).

