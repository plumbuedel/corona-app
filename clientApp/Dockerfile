FROM node:12.18.3-alpine3.9 as build

WORKDIR /app

COPY package.json ./
RUN npm install
COPY . ./
RUN npm run build

FROM nginx:1.19.2-alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80

ENTRYPOINT ["nginx", "-g", "daemon off;"]