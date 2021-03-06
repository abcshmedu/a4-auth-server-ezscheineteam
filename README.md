# OAuth Server - Software-Architektur Sommer 2017

## Heroku Deployment:

Link: [OAuth](http://auth-server-ezschein.herokuapp.com/oauth/)

## REST-API Interface Dokumentation:

### Anwendung:

URI|Methode|Beschreibung
--- | --- | --- 
/users/create|POST|Neuen User anlegen
/users/authenticate|POST|Generiert Token nach einer erfolgreichen Authentifizierung mit AuthData
/users|GET|Alle User auflisten
/users/{id}|PUT|Daten des Users aktualisieren - das Passwort und E-Mail Adresse
/users/{id}|GET|Informationen über den User
/check/{token}|GET|Gibt Auskunft über Gültigkeit des Tokens


### JSON-Objekte:
#### AuthData:
```javascript
{
    "name"  : <string>,
    "password" : <string>
}
```
#### User:
```javascript
{
    "name"    : <string>,
    "password"  : <string>,
    "email" : <string>
}
```
#### Token - Authentifizierungsresponse:
```javascript
{
    "token"    : <string>
}
```
#### Token - /check/{token}:
```javascript
{
    "createdOn": <integer>,
    "validUntil": <integer>,
    "user": {
        "name": <string>,
        "iD": <integer>,
        "active": <boolean>,
        "email": <string>,
        "group": <string>
    },
    "active": <boolean>
}
```

