# Grace View Components Plugin

A Grace plugin for creating reusable, testable and encapsulated view components.

## Grace Version

- Grace **2022.0.0**

## Usage

### Add dependency `view-components`

Adding `view-components` plugin to the `build.gradle`,

```gradle
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "org.graceframework:grace-gradle-plugin:$grailsVersion"
        classpath "org.graceframework.plugins:views-gradle:5.1.0"
    }
}

apply plugin: "org.graceframework.grace-gsp"
apply plugin: "org.graceframework.plugins.views-markup" // Need to build Grace Markup Views

repositories {
    mavenCentral()
}

dependencies {
    implementation "org.graceframework.plugins:view-components:0.0.1"
}

```

Let's start create some Components, `ButtonComponent` in `app/components`,

```bash
.
├── app
│   ├── assets
│   ├── components
│   │   └── demo
│   │       ├── ButtonComponent.groovy
│   │       └── CardComponent.groovy
│   └── views
│       └── components
│           ├── button
│           │   └── button_component.gml
│           └── card
│               └── card_component.gml

```

`ButtonComponent` is just a POGO, we define attribues which will be used in Markup views.

```groovy
class ButtonComponent {
    String name = 'Button'
    String type = 'button'
    String size
    String cssClasses
    String color
    String state
    String icon

    String getCssClasses() {
        String theCssClasses = 'btn'
        if (this.cssClasses) {
            theCssClasses += ' ' + this.cssClasses
        }
        else {
            theCssClasses += " btn-info"
        }
        if (size) {
            theCssClasses += " btn-$size"
        }
        theCssClasses
    }
}
```

In the `app/views/components/button/button_component.gml`,

```html
model {
    String name
    String type
    String size
    String cssClasses
    String color
    String state
    String icon
}

button([type: type, class: cssClasses] + (state == 'disabled' ? [disabled : ''] : [:]) + (color ? [style: 'color: ' + color] : [:])) {
    if (icon) {
        i(class: "bi bi-${icon}") {
        }
    }
    yield name
}
```

Using the `ButtonComponent`, `CardComponent` in your GSPs, it's very easy, `ViewComponents` support custom namespace and tags.

```html

// Using expression in GSP
${new ButtonComponent(name: 'Primary Button', cssClasses: 'btn-primary').render()}

// Using tag in GSP
<vc:render component="button" name="View Components" cssClasses="btn-success" icon="star" />
```

### Using Inline template

You also can write template in Component groovy source using `inline(String templateText)`, it's One File Component!

```groovy
class IconComponent {
    String name

    def render() {
        inline """
i(class: "bi bi-$name") {
}
"""
    }
}
```

## Development

### Build from source

```
git clone https://github.com/graceframework/grace-view-components.git
cd grace-view-components
./gradlew publishToMavenLocal
```

## What's New

### 0.0.1

* Support Grace 2022.0+
* Introduce View Components, using in Controller and GSP
* New taglib: ComponentTagLib


## License

This plugin is available as open source under the terms of the [APACHE LICENSE, VERSION 2.0](http://apache.org/Licenses/LICENSE-2.0)

## Links

- [Grace Website](https://github.com/graceframework/grace-framework)
- [Grace Plugins](https://github.com/grace-plugins)
- [Grace View Components Plugin](https://github.com/grace-plugins/grace-view-components)
- [Grace View Components Guide](https://github.com/grace-guides/gs-view-components)
