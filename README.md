<p align="center">
  <a href="">
    <img src="assets/coteafs-selenium-logo.png" width=300 padding=10 />
  </a>
</p>

<h1 align="center">Selenium WebDriver wrapper Framework which supports Automation of most of the web browsers.</h1>

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)][home]
[![CircleCI](https://circleci.com/gh/WasiqB/coteafs-selenium.svg?style=svg)][circleci]
[![Test Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aselenium&metric=coverage)][coverage]
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aselenium&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.wasiqb.coteafs%3Aselenium)
[![Maintainability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aselenium&metric=sqale_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aselenium&metric=Maintainability)
[![Reliability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aselenium&metric=reliability_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aselenium&metric=Reliability)
[![Security](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aselenium&metric=security_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aselenium&metric=Security)
[![Vulnerability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aselenium&metric=vulnerabilities)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aselenium&metric=new_vulnerabilities)
[![Duplicate Code](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aselenium&metric=duplicated_lines_density)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aselenium&metric=Duplications)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.wasiqb.coteafs/selenium.svg)][maven]
[![Github Releases](https://img.shields.io/github/downloads/WasiqB/coteafs-selenium/total.svg)](https://github.com/WasiqB/coteafs-selenium/releases)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

> **Detailed documentation on main project site is under development.**

## :question: What is this Framework about?

This is a Selenium WebDriver wrapper Framework which enables robust, maintainable and easy to write test scripting. _**It supports latest Selenium WebDriver 4.0 (Alpha)**_ and is ready for main Selenium upgrade.

## :bulb: What features does this framework offer?

Nobody uses anything without knowing what it offers. Some of the key features which this framework offers are as follows:

- Latest Selenium WebDriver 4.0 (Alpha 2)
- On-demand highlighting of Elements
- On-demand delay of test execution by allowing predefined delays
- On-demand headless mode
- Parallel execution of tests on different browsers
- Support Chrome, Firefox, IE and Edge
- CI / CD ready

## :smile: How it is easy to write Tests with this Framework?

Writing tests involves the following steps:

1. :wrench: Config file
1. :page_facing_up: Page object
1. :runner: Page Action
1. :ballot_box_with_check: Tests

### :wrench: Config file.

Config file is by default searched in `src/test/resources` folder. The name of the config file is by default considered as `selenium-config.yaml`. But the same can be overridden by using System property `coteafs.selenium.config` where you can specify the new config file for the test.

#### Sample Config file

`src/test/resources/selenium-config.yaml`

```yaml
browser: CHROME     # CHROME, EDGE, FIREFOX, IE.
url: http://demo.guru99.com/V4/   # Application URL.
headless_mode: false    # true, for headless, else false.
params:     # test specific map.
  user: <test-specific-user>
  password: <test-specific-password>
playback:   # Playback settings.
  screen_state: NORMAL  # FULL_SCREEN, MAXIMIZED, NORMAL
  highlight: true       # true, to highlight elements, else false.
  screen_resolution:    # Screen resolution settings.
    width: 1280     # Screen width.
    height: 768     # Screen height.
  delays:       # On demand delay settings.
    implicit: 60          # Implicit waits in seconds.
    explicit: 60          # Explicit waits in seconds.
    before_key_press: 0   # delay before key press in milliseconds.
    after_key_press: 0    # delay after key press in milliseconds.
    before_mouse_move: 0  # delay before mouse move in milliseconds.
    after_mouse_move: 0   # delay after mouse move in milliseconds.
    before_click: 0       # delay before mouse click in milliseconds.
    after_click: 0        # delay after mouse click in milliseconds.
    page_load: 60         # page load timeout in seconds.
    script_load: 60       # script load timeout in seconds.
    highlight: 500        # highlight delay in milliseconds.
  screenshot:     # Screenshot settings.
    path: ~/screenshots     # default screenshot path.
    prefix: SCR             # screenshot file prefix.
    extension: jpeg         # screenshot file extension.
    capture_on_error: false # screenshot on error.
```

> **Note:** If you find any config not working, feel free to raise an [issue][].

### :page_facing_up: Page objects

To know how to write tests, it's best to see the example as it is self explanatory. Lets have a look at the Login page of Guru99 demo site.

> Remember, `BrowserPage` class needs to be extended for every page and also a flavour of inheritance can be added as per requirement.

#### Sample Page object

```java
package com.github.wasiqb.coteafs.selenium.pages;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.element.IElementActions;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;

public class LoginPage extends BrowserPage {
  public ITextboxActions password () {
    return form ().find (By.name ("password"));
  }

  public IMouseActions signIn () {
    return form ().find (By.name ("btnLogin"));
  }

  public ITextboxActions userId () {
    return form ().find (By.name ("uid"));
  }

  private IElementActions form () {
    return onElement (By.name ("frmLogin"));
  }
}
```

### :runner: Page Action

This is a new concept, here you can define actions specific to each page. This approach abstracts out the page action flows and helps in modularising the classes. So whenever the flow of the page changes, you need to change only at single place.

> For every page action you need to extend `AbstractPageAction`. Since it is a generic class, you need to pass the action class name as it's generic type.
> Also, `perform` method needs to be implemented for every action class.

#### Sample page action

```java
package com.github.wasiqb.coteafs.selenium.pages.action;

import com.github.wasiqb.coteafs.selenium.core.page.AbstractPageAction;
import com.github.wasiqb.coteafs.selenium.pages.LoginPage;
import com.github.wasiqb.coteafs.selenium.pages.MainPage;

public class LoginPageAction extends AbstractPageAction <LoginPageAction> {
  @Override
  public void perform () {
    final LoginPage login = new LoginPage ();
    login.userId ()
      .enterText (value ("UserId"));
    login.password ()
      .enterText (value ("Password"));
    login.signIn ()
      .click ();

    final MainPage main = new MainPage ();
    main.managerIdBanner ()
      .verifyText ()
      .endsWith ("Manger Id : " + value ("UserId"));
  }
}
```

### :white_check_mark: Tests

Test which are written using this framework are slightly different than usual. In the tests, Page actions is used instead of page objects. This can be demonstrated as shown below:

#### Sample Test

> Every test class extends `BrowserTest` class.

```java
package com.github.wasiqb.coteafs.selenium;

import static com.github.wasiqb.coteafs.selenium.config.ConfigUtil.appSetting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.selenium.core.BrowserTest;
import com.github.wasiqb.coteafs.selenium.pages.MainPage;
import com.github.wasiqb.coteafs.selenium.pages.action.LoginPageAction;

public class SeleniumTest extends BrowserTest {
  private MainPage main;

  @BeforeClass
  public void setupMethod () {
    this.main = new MainPage ();
    this.main.onDriver ()
      .navigateTo (appSetting ().getUrl ());
  }

  @Test
  public void testSignIn () {
    final LoginPageAction login = new LoginPageAction ();
    login.addInputValue ("UserId", appSetting ().getParams ()
      .get ("user"))
      .addInputValue ("Password", appSetting ().getParams ()
        .get ("password"))
      .perform ();
  }
}
```

## :pushpin: Usage?

You can use the following dependency into your `pom.xml` to use this library.

```xml
<dependency>
  <groupId>com.github.wasiqb.coteafs</groupId>
  <artifactId>selenium</artifactId>
  <version>2.0.0</version>
</dependency>
```

Or you can add the following into your `build.gradle` file.

 ```gradle
 compile "com.github.wasiqb.coteafs:selenium:2.0.0"
 ```
 
## :question: Need Assistance?

- Directly chat with me on my [site][] and I'll revert to you as soon as possible.
- Discuss your queries by writing to me @ [wasbhamla2005@gmail.com][mail]
- If you find any issue which is bottleneck for you, [search the issue tracker][tracker] to see if it is already raised.
- If not raised, then you can create a [new issue][issue] with required details as mentioned in the issue template.

## :star2: What you do if you like the project?

- Spread the word with your network.
- **Star** the project to make the project popular.
- Stay updated with the project progress by **Watching** it.
- **Contribute** to fix open issues, documentations or add new features. To know more, see our [contributing][] page.
- I would be delighted if you can **Sponsor** this project and provide your support to open source development by clicking on the Sponsor button on the top of this repository.

## :white_check_mark: Contributors

<div>
  <ul>
    <li>
      <a href="https://github.com/WasiqB">
        <img alt="Wasiq Bhamla: Framework developer and maintainer." src="https://github.com/WasiqB.png" width=100 height=100 />
      </a>
    </li>
    <li>
      <a href="https://github.com/mfaisalkhatri">
        <img alt="Mohammad Faisal Khatri: Framework Tester." src="https://github.com/mfaisalkhatri.png" width=100 height=100 />
      </a>
    </li>
  </ul>
</div>

## :ticket: Versioning ideology

<p align="left">
  <a href="http://semver.org/">
    <img src="assets/semver.png" width=300 />
  </a>
</p>

## :copyright: Wasiq Bhamla

<p align="left">
  <a href="http://www.apache.org/licenses/LICENSE-2.0">
    <img src="http://www.apache.org/img/asf_logo.png" width=300 />
  </a>
</p>

[home]: https://github.com/wasiqb/coteafs-selenium
[circleci]: https://circleci.com/gh/WasiqB/coteafs-selenium
[coverage]: https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aselenium&metric=Coverage
[maven]: https://maven-badges.herokuapp.com/maven-central/com.github.wasiqb.coteafs/selenium
[site]: https://wasiqb.github.io
[tracker]: https://github.com/WasiqB/coteafs-selenium/issues?q=something
[issue]: https://github.com/WasiqB/coteafs-selenium/issues/new
[contributing]: .github/CONTRIBUTING.md
[mail]: mailto:wasbhamla2005@gmail.com
