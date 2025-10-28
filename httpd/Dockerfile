FROM httpd:2.4
# Enable proxy modules
RUN sed -i 's/#LoadModule proxy_module/LoadModule proxy_module/g' /usr/local/apache2/conf/httpd.conf \
 && sed -i 's/#LoadModule proxy_http_module/LoadModule proxy_http_module/g' /usr/local/apache2/conf/httpd.conf

# Proxy root to frontend container, and /api to backend
RUN echo "" >> /usr/local/apache2/conf/httpd.conf \
 && echo "# Proxy configuration for Front and API" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPreserveHost On" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPass / http://front:80/" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPassReverse / http://front:80/" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPass /api/ http://backend:8080/" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPassReverse /api/ http://backend:8080/" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPass /students http://backend:8080/students" >> /usr/local/apache2/conf/httpd.conf \
 && echo "ProxyPassReverse /students http://backend:8080/students" >> /usr/local/apache2/conf/httpd.conf
