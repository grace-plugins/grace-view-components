[![Main branch build status](https://github.com/grace-plugins/grace-view-components/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-plugins/grace-view-components/actions?query=workflow%3A%Grace+CI%22)
[![Apache 2.0 license](https://img.shields.io/badge/License-APACHE%202.0-green.svg?logo=APACHE&style=flat)](https://opensource.org/licenses/Apache-2.0)
[![Latest version on Maven Central](https://img.shields.io/maven-central/v/org.graceframework.plugins/view-components.svg?label=Maven%20Central&logo=apache-maven&style=flat)](https://search.maven.org/search?q=g:org.graceframework.plugins)
[![Grace Document](https://img.shields.io/badge/Grace_Document-latest-blue?style=flat&logo=asciidoctor&logoColor=E40046&labelColor=ffffff&color=f49b06)](https://plugins.graceframework.org/grace-view-components/latest/)
[![Grace on X](https://img.shields.io/twitter/follow/graceframework?style=social)](https://x.com/graceframework)

[![Groovy Version](https://img.shields.io/badge/Groovy-3.0.23-blue?style=flat&color=4298b8)](https://groovy-lang.org/releasenotes/groovy-3.0.html)
[![Grace Version](https://img.shields.io/badge/Grace-2022.2.9-blue?style=flat&color=f49b06)](https://github.com/graceframework/grace-framework/releases/tag/v2022.2.9)

# Grace View Components

A Grace plugin for creating reusable, testable and encapsulated view components.

## Grace Version

- Grace **2022.2.9**
- Groovy **3.0.23**

## Ducumentation

* [Latest](https://plugins.graceframework.org/grace-view-components/latest/)

## Usage

### Add dependency `view-components`

Adding `view-components` plugin to the `build.gradle`,

```gradle
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "org.graceframework:grace-gradle-plugin:$graceVersion"
        classpath "org.graceframework.plugins:views-gradle:5.2.4"
    }
}

apply plugin: "org.graceframework.grace-gsp"
apply plugin: "org.graceframework.plugins.views-markup" // Need to build Grace Markup Views

repositories {
    mavenCentral()
}

dependencies {
    implementation "org.graceframework.plugins:views-markup:5.2.4"
    implementation "org.graceframework.plugins:view-components:VERSION"
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

// Custom namespace for components supports in 0.0.2
// I'm sorry, it's not supported by Grails, you can reply and make a request if you are interested, go to https://github.com/grails/grails-gsp/issues/324
<vc:button type="button" name="Icon Button" cssClasses="btn-primary" icon="box" />

<vc:card title="My First Component" content="This is the first Card" />

<g:each var="post" in="${Post.list()}">
    <vc:card title="${post.title}" content="${post.body}" />
    // or
    <vc:card model="${post}" />
</g:each>

<vc:icon name="alarm" />
<vc:icon name="apple" />
<vc:icon name="bag" />
<vc:icon name="bank" />
<vc:icon name="box" />
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
git clone https://github.com/grace-plugins/grace-view-components.git
cd grace-view-components
./gradlew publishToMavenLocal
```

## What's New

### v0.2.0

* Upgrade to Grace 2022.2.9
* Upgrade to Gradle 7.6.4
* Upgrade to Grails Asset Pipeline 5.2.7
* Upgrade to Grails Views 5.2.8
* Upgrade to Groovy 3.0.23
* Remove grails-plugin.xml in favor of the generated plugin meta file
* Set archiveClassifier to 'plugin'
* Add artifact grails-plugin.xml

### v0.1.0

* Refactor app directory and packages of the plugin
* Upgrade to Grace 2022.2.4
* Upgrade to Groovy 3.0.17

### v0.0.2

* Upgrade to Grace 2022.2.0
* Support Custom namespace for components

### v0.0.1

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
