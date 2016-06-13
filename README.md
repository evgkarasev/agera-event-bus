# agera event bus

#### Sample
`Broastcast` -> `BroadcastReceiver`(static) -> `IntentService`(Inhibitor)   
--> `AgeraBus.repository().accept(new StringEvent(UPDATE))`(post an event) -> Activity `update`.

#### Usage

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

