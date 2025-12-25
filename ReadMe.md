# 数独游戏 (Sudoku) | Sudoku Game

一个使用Java Swing开发的图形化数独游戏，提供多种难度选择和友好的用户界面。

A graphical Sudoku game developed using Java Swing, offering multiple difficulty levels and a user-friendly interface.

![License](https://img.shields.io/badge/license-Dual%20License-blue) ![Java](https://img.shields.io/badge/Java-8%2B-orange) ![Platform](https://img.shields.io/badge/platform-Windows-green)

## 📦 下载游戏 | Download

[![User Guide](https://img.shields.io/badge/用户指南-User%20Guide-blue)](https://github.com/Muimi272/Sudoku/blob/main/dist/README.md)

请从仓库的 `dist` 目录下载所有文件来运行游戏。

---

## 🎯 项目概览 | Project Overview

- 🎮 **零安装运行**：内置Java运行环境，无需预装Java
- 🎨 **现代界面**：自定义圆角按钮，清新配色设计
- 🎲 **三种难度**：简单、中等、困难，适合不同水平
- ✅ **实时验证**：即时检查答案，立即反馈结果
- 🌐 **完全中文**：本土化界面，符合用户习惯

## 🚀 快速开始 | Quick Start

### 方式一：直接运行（推荐）| Direct Run (Recommended)
1. 下载 `dist` 目录下的所有文件
2. 进入 `dist` 目录
3. 双击 `Start.bat` 启动游戏
4. 详细使用说明请查看 [用户指南](dist/README.md)

### 方式二：编译运行 | Compile and Run
```bash
# 克隆仓库
git clone https://github.com/Muimi272/Sudoku.git

# 编译项目
javac src/main/java/sudoku/*.java

# 运行游戏
java -cp src/main/java sudoku.Main
```

## 功能特性 | Features

- 🎮 **图形化界面**：使用Java Swing构建的直观用户界面
  - **Graphical Interface**: Intuitive user interface built with Java Swing
- 🎯 **多种难度**：提供简单、中等、困难三种难度级别
  - **Multiple Difficulty Levels**: Three difficulty levels - Easy, Medium, and Hard
- ✅ **答案验证**：实时检查答案是否正确
  - **Answer Validation**: Real-time checking of answer correctness
- 🔄 **游戏控制**：支持重新开始、重置游戏等功能
  - **Game Controls**: Support for restart, reset, and other game functions
- 🎨 **美观设计**：自定义圆角按钮和现代化界面设计
  - **Beautiful Design**: Custom round buttons and modern interface design

---

## 项目结构 | Project Structure

### 源码结构 | Source Code Structure
```
src/main/java/sudoku/
├── Main.java          # 主程序入口 | Main program entry
├── Sudoku.java        # 数独游戏逻辑 | Sudoku game logic
├── Window.java        # 游戏窗口界面 | Game window interface
├── RoundButton.java   # 自定义圆角按钮组件 | Custom round button component
└── META-INF/
    └── MANIFEST.MF    # JAR清单文件 | JAR manifest file
```

### 发布文件 | Release Files
```
dist/
├── Start.bat                    # 启动脚本
├── Start_with_console.bat       # 调试启动脚本
├── Sudoku.jar                   # 游戏核心文件
├── runtime/                     # Java运行环境
│   ├── bin/                     # 可执行文件
│   ├── lib/                     # 系统库文件
│   └── conf/                    # 配置文件
├── ReadMe.pdf                   # 原始使用文档
└── README_USER.md               # 用户指南
```

---

## 如何运行 | How to Run

### 前置要求 | Prerequisites

- Java Runtime Environment (JRE) 8 或更高版本
- Java Runtime Environment (JRE) 8 or higher

### 运行步骤 | Running Steps

1. 克隆或下载本项目
   - Clone or download this project
2. 编译Java文件：
   - Compile Java files:
   ```bash
   javac sudoku/*.java
   ```
3. 运行游戏：
   - Run the game:
   ```bash
   java sudoku.Main
   ```

或者直接运行已编译的JAR文件：
Or directly run the compiled JAR file:
```bash
java -jar Sudoku.jar
```

---

## 游戏玩法 | How to Play

1. 启动游戏后，选择难度级别（简单/中等/困难）
   - After starting the game, select difficulty level (Easy/Medium/Hard)
2. 在空格中填入1-9的数字
   - Fill empty cells with numbers 1-9
3. 每行、每列和每个3×3宫格内的数字不能重复
   - Numbers cannot repeat in any row, column, or 3×3 box
4. 完成后点击"提交答案"检查结果
   - Click "Submit Answer" to check results when completed
5. 可以随时重新开始或重置当前游戏
   - You can restart or reset the current game at any time

---

## 技术实现 | Technical Implementation

- **编程语言**：Java
  - **Programming Language**: Java
- **GUI框架**：Java Swing
  - **GUI Framework**: Java Swing
- **核心算法**：回溯算法生成数独谜题
  - **Core Algorithm**: Backtracking algorithm for Sudoku puzzle generation
- **设计模式**：面向对象设计
  - **Design Pattern**: Object-oriented design

---

## 许可证 | License

本项目采用双重许可证。详细信息请查看 [LICENSE](LICENSE) 文件。
This project uses a dual license. For detailed information, please see the [LICENSE](LICENSE) file.

### 快速概览 | Quick Overview

- **开源项目 | Open Source Projects**: 免费，只需保留版权声明
- **商业项目 | Commercial Projects**: 需要联系作者获得许可

**联系方式 | Contact**: Muimi_mail@163.com

---

## 作者信息 | Author Information

- **GitHub**：[Muimi272](https://github.com/Muimi272)
- **邮箱**：Muimi_mail@163.com
- **Email**: Muimi_mail@163.com

## 📋 版本信息 | Version Information

### 当前版本 | Current Version
- 🎮 基础数独游戏功能
- 🎨 现代化UI设计
- 🎯 三种难度级别（简单、中等、困难）

## 🤝 贡献 | Contributing

欢迎提交Issue和Pull Request来改进这个项目！
Welcome to submit Issues and Pull Requests to improve this project!

---

*享受数独游戏的乐趣！*
*Enjoy the fun of Sudoku game!*

---

*享受数独游戏的乐趣！*
*Enjoy the fun of Sudoku game!*
