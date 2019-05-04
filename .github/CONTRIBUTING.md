# Contributing to coteafs-selenium.

:+1: :tada: Firstly, thanks for taking the time to contribute! :tada: :+1:

The following is a set of guidelines for contributing to **coteafs-selenium** which is hosted on GitHub. These are mostly guidelines, not rules. Use your best judgment, and feel free to propose changes to this document in a pull request.

## Code contribution

There are some process which are in place to help maintain the quality of the framework. To adhere to this process, some coding standards and CI pipelines are defined along with static code analysis. The same is detailed below:

### Git workflow

Since the repository is hosted on GitHub, I have configured the GitHub to only accept **signed commits** from any contributor (_including me :wink:_). So make sure that you are signing your commits before sending PR, **else the PR will be rejected**. To know more about signed commits, check out this [post][sign-commit].

### Branching strategy

I have defined a specific Branching strategy where **NO COMMITS** are done directly into `master` branch.

There are 3 main branches:
- `develop`: All feature branches will be merged into this branch after `PR` review.
- `release`: When `develop` branch is clean and all CI tests are also **green**, then `develop` branch is merged into this branch via `PR`. After merge, a `beta` release of version is published to Maven central.
- `master`: After successful Beta testing, `release` branch is then merged into `master` via `PR`. After merge, final release version cut is published to Maven central.

Any work being done on any open tickets, should be done in a new branch with naming pattern `issue-<ticket no>` created from `develop` branch.

### PR pre-requisites

Any PR raised should make sure following checks are successful:
- PR is raised to merge changes to `develop` branch.
- Commits are signed.
- There is at least one reviewer (that would be me.)
- Circle CI tests are green.
- Branch is up to date with `develop` branch.

### Project tracking

We make sure that whatever is being committed to the code base, is tracked against an issue ticket. Hence, each planned versions are being tracked in `Project` tab on GitHub. Hence, it is mandatory to keep the ticket status updated for which you may be working on.

### Circle CI pipelines

The framework is configured with Circle CI to run tests on **Chrome browser** to make sure that the framework is healthy. This integration is useful when there is multiple contributors working on the project and it is mandatory to add tests for the code you have written. These tests will be executed on every commits to the issue branch.

Following is the checks which are executed:
- Tests coverage
- Static Code analysis

### Code Styling

When many contributors are working together, then there is always chance for different code styling. To make sure every member is using same coding style, it is advisable that you import code styling formatter from the [java formatter][formatter] repository into your IDE.

Make sure to format the code before committing sending **PR**.

### Test coverage

For assuring quality of framework to prospective users, test coverage plays an important role. That's why we want to achieve a benchmark of **80% or more** of overall coverage. It will be advisable to add tests for any new code which you may be adding.

### SonarCloud Code Quality monitoring

For each commit to any of the branches described above, CI will also execute static code analysis. It is advisable to check the [SonarCloud][sonar] for any coding issues and solve any issues related to your code before sending across for **PR**.

## Issues and Suggestions.

If you find any issue in the framework or you have some suggestions for enhancement in the framework then feel free to raise an issue for the same. Together we can make the framework even for solid and more easy for other Test Engineers to use in their daily Automation tasks.

[sign-commit]: https://help.github.com/en/articles/signing-commits
[formatter]: https://github.com/WasiqB/java-formatter
