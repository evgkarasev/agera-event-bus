# Agera Event Bus

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/drakeet/agera-event-bus/blob/master/LICENSE)
![maven-central](https://img.shields.io/maven-central/v/me.drakeet.agera/bus.svg) 

#### Sample
`Broastcast` -> `BroadcastReceiver`(static) -> `IntentService`(Inhibitor)   
--> `AgeraBus.repository().accept(new StringEvent(UPDATE))`(post an event) -> Activity `update`.

#### Usage

To add a dependency using Gradle:

```groovy
compile 'me.drakeet.agera:bus:1.0.0'

compile 'com.squareup.retrofit2:retrofit:2.0.2'
compile 'com.google.android.agera:agera:1.1.0-beta2'
```

###### register

```java
AgeraBus.repository().addUpdatable(this);
```

###### unregister

```java
AgeraBus.repository().removeUpdatable(this);
```

###### post an event

```java
AgeraBus.repository().accept(new YourEvent());
```

###### on evnet received

```java
@Override public void update() {
    if (AgeraBus.repository().get() instanceof YourEvent) {
        // ...
    }
}
```

###### check if it is `DeadEvent`

```java
AgeraBus.repository().hasObservers()
```

