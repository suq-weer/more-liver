项目简介
=======

>此为本人制作的第一个模组，目的是更好的学习 MC 模组开发，如果我有高血压操作、未来可能会遇见的麻烦事，望请大佬提个 issue 指导一下，小辈会非常感激不尽！

*更多肝度，顾名思义，为了肝而肝，就是要励志成为无尽贪婪级别的模组！*

**当前游戏内容过少，不适合正式游玩，所以暂时不会出现仓库发行版，也不会考虑上传 Modrinth 和 Neoforge。**

版权声明
=======

***什么？你是来抄代码的？欢迎欢迎（***

首先**感谢您对本项目的认可与支持**<small><del>（能被大家认可也是我这辈子的福气了）</del></small>，**但在您进行二次开发前，请遵循知识共享署名—相同方式共享 4.0 协议国际版许可证书：**

>**此许可证要求再使用者将功劳归于创建者。它允许再用户以任何媒体或格式分发、重新混合、改编和构建材料，甚至用于商业目的。如果其他人重新混合、改编或基于这些材料进行构建，他们必须以相同的条款许可修改后的材料。**

要查阅此许可证书的副本，请前往：<https://creativecommons.org/licenses/by-sa/4.0/>

**证书保护范围定义：本项目仓库（或者其他由本仓库创建者创建本项目的副本）下 `src` 文件夹下的所有内容与 `build.gradle` 和 `gradle.perproties` 与官方 MDK 模板不同的部分。（ `generated` 文件夹里面的内容除外，因为它是 NeoGradle 生成的）当出现本项目编译后的版本时，应当包括编译程序会生成的所有文件。**

如果出现各语言翻译相混淆的情况，应当按照中文版本为准。

导入方法
=======

本项目**使用 Neoforge 官方 MDK 模板进行开发**，原理上与官方的 MDK 模板导入方法相似。以下给出原文：

Once you have your clone, simply open the repository in the IDE of your choice. The usual recommendation for an IDE is either IntelliJ IDEA or Eclipse.

> **Note**: For Eclipse, use tasks in `Launch Group` instead of ones founds in `Java Application`. A preparation task must run before launching the game. NeoGradle uses launch groups to do these subsequently.

If at any point you are missing libraries in your IDE, or you've run into problems you can
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything
{this does not affect your code} and then start the process again.