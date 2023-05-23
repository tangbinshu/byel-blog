const path = require('path');

module.exports = {
  // 入口文件
  entry: './src/main.js',

  // 输出配置
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js'
  },

  // 模块处理规则
  module: {
    rules: [
      {
        test: /\.js$/, // 匹配所有的.js文件
        exclude: /node_modules/, // 排除node_modules目录
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env']
          }
        }
      }
    ]
  }
};
