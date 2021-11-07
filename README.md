<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]


<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/giovalgas/Mines">
    <img src="https://lh3.googleusercontent.com/UFbXAadvQV6kN084EsCNdDPqi653aEgrvqBvdVdj4iP4pVrjjRj6M67UuFwIyMCx6g8U5erTlvFyrlbg2Eie6w=s400" alt="Logo" width="128" height="128">
  </a>

  <h3 align="center">Compressible Blocks</h3>

  <p align="center">
    Adds the possibility to compress blocks! <br />
    Supports 1.8.8-1.16.5
    <br />
    <br />
    <a href="https://youtu.be/KLSvBaYkSnk">View Demo</a>
    ·
    <a href="https://github.com/giovalgas/CompressibleBlocks/issues">Report Bug</a>
    ·
    <a href="https://github.com/giovalgas/CompressibleBlocks/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
  * [Configuration](#configuration)
* [Usage](#usage)
* [Contributing](#contributing)
* [Contact](#contact)

<!-- ABOUT THE PROJECT -->
## About The Project
<table>
  <tr>
    <td><img src="https://i.gyazo.com/f71d42a22a00b0b89de6acc14c52a501.gif"></td>
    <td><img src="https://i.gyazo.com/580bffe16c614b466536f1b91467e9cd.gif"></td>
  </tr>
 </table>

Although this was made with the intent of adding it to my portfolio I fully intent to keep updating fixing bugs.

Features:
* Configurable.
* No lag.
* Supports most versions of mc.


### Built With
This project was built with:
* [Spigot](https://www.spigotmc.org/)
* [Java](https://java.com/pt-BR/)
* [XSeries](https://github.com/CryptoMorin/XSeries)
* [NBTAPI](https://www.spigotmc.org/resources/nbt-api.7939/)

### Support the dev

Enjoyed the plugin and want to support me monetarily? [buy me a coffe!](https://www.buymeacoffee.com/giovalgasdev)
Any donations are going to be **greatly appreciated!**
<!-- GETTING STARTED -->
## Getting Started

To get this plugin up and running you will only need to follow the following steps.

### Prerequisites

You will need these installed in your server before proceeding.

* [Spigot](https://www.spigotmc.org/)


### Installation

1. Download the plugin at [https://github.com/giovalgas/CompressibleBlocks/releases](https://github.com/giovalgas/CompressibleBlocks/releases)
2. Put the downloaded jar into the plugins folder (yourServerFolder/plugins)

### Configuration

```yaml
#Config.yml - Compressible Blocks  
  
console-prefix: "[CompressibleBlocks] "  
  
# Compressed block ItemStack format  
compressed-block:  
  name: "&9Compressed %material_type% Block"  
  lore:  
    - "&7This is a compressed &e%material_type% &7block"  
  - "&7Place this in a crafting table to get 9 &e%material_type% &7blocks"  
  
  
#list of materials that can be compressed  
#uses the spigot class Material here is a list https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html  
compressible-blocks:  
  - STONE  
  - BRICKS
```

### Language

```yaml
#Language.yml - CompressibleBlocks  
  
messages:  
  message-prefix: "&c[&6CompressibleBlocks&c] "  
  
  help:  
  - "&8&m---------------------------------"  
  - "&e&lCompressibleBlocks"  
  - "&7▪ &e/cp &7- Displays this list"  
  - "&7▪ &e/cp list &7- Opens the compressible blocks list"  
  - "&8&m---------------------------------"  
  
  no-permission: "&cYou don't have the permission needed to execute that command."  
  reloading-plugin: "&ePlugin reloaded successfully!"  
  
  page-error: "&cThere is no next/previous page."  
  opening-page: "&eOpening the compressible blocks list!"  
  
sounds:  
  click-sound: CLICK
```

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- CONTACT -->
## Contact

Giovani Valgas - [@giovalgas](https://twitter.com/giovalgas) - giovalgascom@gmail.com

Project Link: [https://github.com/giovalgas/CompressibleBlocks](https://github.com/giovalgas/CompressibleBlocks)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/giovalgas/CompressibleBlocks.svg?style=flat-square
[contributors-url]: https://github.com/giovalgas/CompressibleBlocks/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/giovalgas/CompressibleBlocks.svg?style=flat-square
[forks-url]: https://github.com/giovalgas/CompressibleBlocks/network/members
[stars-shield]: https://img.shields.io/github/stars/giovalgas/CompressibleBlocks.svg?style=flat-square
[stars-url]: https://github.com/giovalgas/CompressibleBlocks/stargazers
[issues-shield]: https://img.shields.io/github/issues/giovalgas/CompressibleBlocks.svg?style=flat-square
[issues-url]: https://github.com/giovalgas/CompressibleBlocks/issues
