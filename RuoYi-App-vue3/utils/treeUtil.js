/**
 * 将扁平化数组转换为树形结构
 * @param {Array} data 扁平化数据数组
 * @param {Object} options 配置项
 * @param {String} [options.idKey='id'] id字段名
 * @param {String} [options.parentKey='pid'] parentId字段名
 * @param {String} [options.childrenKey='children'] children字段名
 * @returns {Array} 树形结构数据
 */
export function arrayToTree(data, options = {}) {
  const {
    idKey = 'id',
    parentKey = 'pid',
    childrenKey = 'children'
  } = options;

  // 创建id到节点的映射
  const nodeMap = new Map();
  data.forEach(item => nodeMap.set(item[idKey], item));

  // 构建树形结构
  const tree = [];
  data.forEach(item => {
    const parentId = item[parentKey];
    
    // 如果是根节点
    if (!parentId || !nodeMap.has(parentId)) {
      tree.push(item);
      return;
    }
    
    // 找到父节点并添加当前节点为子节点
    const parent = nodeMap.get(parentId);
    if (!parent[childrenKey]) {
      parent[childrenKey] = [];
    }
    parent[childrenKey].push(item);
  });

  return tree;
}

/**
 * 示例用法
 * const flatData = [
 *   { id: 1, pid: 0, name: '父节点1' },
 *   { id: 2, pid: 1, name: '子节点1' },
 *   { id: 3, pid: 1, name: '子节点2' },
 *   { id: 4, pid: 0, name: '父节点2' },
 * ];
 * 
 * const treeData = arrayToTree(flatData, {
 *   idKey: 'id',
 *   parentKey: 'pid',
 *   childrenKey: 'children'
 * });
 */