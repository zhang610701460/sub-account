/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.kanke.modules.ahdx.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
@TableName("t_feedback")
public class FeedBack implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private Integer id;
	/**
	 * 策略类型
	 */
	private String strategy;
	/**
	 * 推荐播放量
	 */
	private Integer recplaycount;
	/**
	 * 整体播放量
	 */
	private Integer totalpalycount;
	/**
	 * 统计时间(数据时间)
	 */
	private Date statisticstime;
	/**
	 * 整体播放时长
	 */
	private Integer countplaytime;

	/**
	 * 场景类型
	 */
	private String scenetype;

	/**
	 * 影视类型
	 */
	private String videotype;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public Integer getRecplaycount() {
		return recplaycount;
	}

	public void setRecplaycount(Integer recplaycount) {
		this.recplaycount = recplaycount;
	}

	public Integer getTotalpalycount() {
		return totalpalycount;
	}

	public void setTotalpalycount(Integer totalpalycount) {
		this.totalpalycount = totalpalycount;
	}

	public Date getStatisticstime() {
		return statisticstime;
	}

	public void setStatisticstime(Date statisticstime) {
		this.statisticstime = statisticstime;
	}

	public Integer getCountplaytime() {
		return countplaytime;
	}

	public void setCountplaytime(Integer countplaytime) {
		this.countplaytime = countplaytime;
	}

	public String getScenetype() {
		return scenetype;
	}

	public void setScenetype(String scenetype) {
		this.scenetype = scenetype;
	}

	public String getVideotype() {
		return videotype;
	}

	public void setVideotype(String videotype) {
		this.videotype = videotype;
	}
}
