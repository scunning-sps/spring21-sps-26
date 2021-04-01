This directory is where you'll write all of your code!

By default it contains a barebones portfolio web app. To run a local server,
execute this command:

```
mvn package exec:java
```

## Datastore emulator
To avoid using the production Datastore database while testing, follow these steps to emulate a Datastore instance locally

1. Set the project id in cloudshell using the follwing command:

```
gcloud config set project [PROJECT_ID]
```

For the specific case of our project, use the project id `spring21-sps-26`. You can copy and paste the follwing:

```
gcloud config set project spring21-sps-26
```

2. Open a second cloudshell. 
3. Set the project id in the second cloudshell too. 
4. Run the following command to start the Datastore emulator:
```
gcloud beta emulators datastore start
```
5. In the output of running the previous command, look for a like that looks like this:

```
Storage: /tmp/tmp.YOUR_PATH_HERE/emulators/datastore/WEB-INF/appengine-generated/local_db.bin
```

The `YOUR_PATH_HERE` will be a random string of characters.
6. Now go back to your first cloudshell and run the following command, replacing `YOUR_PATH_HERE` with the string you got on your second cloudshell.
```
$(gcloud beta emulators datastore env-init --data-dir=/tmp/tmp.YOUR_PATH_HERE/emulators/datastore)
```
This command will link your first cloudshell with the emulator - which is running on the second cloudshell.

7. Run your project executing maven on the first cloudshell.

## API documentation

### Guides: list
Retrieves a list of guides.

#### Request

##### Http request

| Method | Endpoint |
| --- | --- |
| `GET` | `/guides` |

##### Parameters
There are not any parameters for this method at the moment.

##### Request Body
No need to provide a body with this method.

#### Response

If the request succeeds, the server responds with an HTTP `200 OK`.

##### Response Body
The body of the response contains a list with the existing guides.
```JSON
[
    {
        "id": number,
        "timestamp": number,
        "title": string,
        "description": string, 
        "content": string
    },
    ...
]
```

### Guides: insert
Adds a guide.

#### Request

##### Http request

| Method | Endpoint |
| --- | --- |
| `POST` | `/guides` |

##### Parameters
| Parameter Name | Value | Description |
| --- | --- | --- |
| **Required parameters** |
| title | string | Title of the new guide. |
| description | string | Description of the new guide. |
| content | string | Content of the new guide. |

##### Request Body
No need to provide a body with this method.

#### Response

If the request succeeds, the server responds with an HTTP `200 OK`.

##### Response Body
The body of the response contains the guide that was just added.
```JSON
{
    "id": number,
    "timestamp": number,
    "title": string,
    "description": string, 
    "content": string
}
```